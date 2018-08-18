package com.javaapi.test.buisness.data.json.jackson.sample;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class JacksonDemo {
    public static final ObjectMapper MAPPER = new ObjectMapper();

    public static <T> T deserialize(byte[] bytes, Class<T> clazz) {
        if (bytes == null) {
            return null;
        }
        if (clazz == null) {
            return null;
        }
        T parse = null;
        try {
            parse = MAPPER.readValue(bytes, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parse;
    }

    public static <T> List<T> deserializeArray(byte[] bytes,Class<T> clazz) {
        if (bytes == null) {
            return null;
        }
        List<T> parse = null;
        try {
            parse = MAPPER.readValue(bytes,getCollectionType(ArrayList.class,clazz));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parse;
    }

    public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return MAPPER.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

    @Test
    public void objectToJson() throws ParseException, IOException {
        User user = new User();
        user.setName("小民");
        user.setEmail("xiaomin@sina.com");
        user.setAge(20);

        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        user.setBirthday(dateformat.parse("1996-10-01"));

        /**
         * ObjectMapper是JSON操作的核心，Jackson的所有JSON操作都是在ObjectMapper中实现。
         * ObjectMapper有多个JSON序列化的方法，可以把JSON字符串保存File、OutputStream等不同的介质中。
         * writeValue(File arg0, Object arg1)把arg1转成json序列，并保存到arg0文件中。
         * writeValue(OutputStream arg0, Object arg1)把arg1转成json序列，并保存到arg0输出流中。
         * writeValueAsBytes(Object arg0)把arg0转成json序列，并把结果输出成字节数组。
         * writeValueAsString(Object arg0)把arg0转成json序列，并把结果输出成字符串。
         */
        ObjectMapper mapper = new ObjectMapper();

        //User类转JSON
        //输出结果：{"name":"小民","age":20,"birthday":844099200000,"email":"xiaomin@sina.com"}
        String json = mapper.writeValueAsString(user);
        System.out.println(json);

        //Java集合转JSON
        //输出结果：[{"name":"小民","age":20,"birthday":844099200000,"email":"xiaomin@sina.com"}]
        List<User> users = new ArrayList<User>();
        users.add(user);
        String jsonlist = mapper.writeValueAsString(users);
        System.out.println(jsonlist);
    }

    @Test
    public void jsonToObject() throws ParseException, IOException {
        String json = "{\"name\":\"小民\",\"age\":20,\"birthday\":844099200000,\"email\":\"xiaomin@sina.com\"}";

        /**
         * ObjectMapper支持从byte[]、File、InputStream、字符串等数据的JSON反序列化。
         */
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(json, User.class);
        System.out.println(user);
    }

    /**
     * 目前想要使用jackson的反序列化，
     * 反序列化的时候必须传入具体java类型
     *
     * @throws Exception
     */
    @Test
    public void testSerDeser() throws Exception {
        User user = new User();
        user.setName("小民");
        user.setEmail("xiaomin@sina.com");
        user.setAge(20);
        ObjectMapper mapper = new ObjectMapper();
        byte[] bytes = mapper.writeValueAsBytes(user);
        System.out.println("bytes = " + new String(bytes));
        User user1 = mapper.readValue(bytes, User.class);
        System.out.println("user1 = " + user1);
    }

    @Test
    public void testSerDeser2() throws Exception {
        User user = new User();
        user.setName("小民");
        user.setEmail("xiaomin@sina.com");
        user.setAge(20);
        ObjectMapper mapper = new ObjectMapper();
        byte[] bytes = mapper.writeValueAsBytes(user);
        System.out.println("bytes = " + new String(bytes));
        User deserialize = deserialize(bytes, User.class);
        System.out.println("deserialize = " + deserialize);
        System.out.println("deserialize = " + deserialize.getEmail());
    }

    /**
     * http://www.cnblogs.com/quanyongan/archive/2013/04/16/3024993.html
     * @throws Exception
     */
    @Test
    public void testSerDeserList() throws Exception {
        User user = new User();
        user.setName("小民");
        user.setEmail("xiaomin@sina.com");
        user.setAge(20);
        User user2 = new User();
        user2.setName("小民");
        user2.setEmail("xiaomin@sina.com");
        user2.setAge(20);

        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user2);


        ObjectMapper mapper = new ObjectMapper();
        byte[] bytes = mapper.writeValueAsBytes(list);
        System.out.println("bytes = " + new String(bytes));
        List<User> deserialize = deserializeArray(bytes,User.class);
        System.out.println("deserialize = " + deserialize);
        for (User user1 : deserialize) {
            System.out.println("user1.getEmail() = " + user1.getEmail());
        }
    }
}