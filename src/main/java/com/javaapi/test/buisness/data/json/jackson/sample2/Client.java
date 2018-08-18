package com.javaapi.test.buisness.data.json.jackson.sample2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Test;

import java.util.HashMap;

/**
 *Data Binding：最方便使用.
 */
public class Client {
    private static final String MODEL_BINDING = "{\"name\":\"name1\",\"type\":1}";
    private static final String GENERIC_BINDING = "{\"key1\":{\"name\":\"name2\",\"type\":2},\"key2\":{\"name\":\"name3\",\"type\":3}}";
    private static final String TREE_MODEL_BINDING = "{\"treekey1\":\"treevalue1\",\"treekey2\":\"treevalue2\",\"children\":[{\"childkey1\":\"childkey1\"}]}";

    /**
     * (1)Full Data Binding：
     * @throws Exception
     */
    @Test
    public void fullDataBinding() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        Model user = mapper.readValue(MODEL_BINDING, Model.class);//readValue到一个实体类中.
        System.out.println(user.getName());
        System.out.println(user.getType());
    }
    /**
     * (2)Raw Data Binding：

     Concrete Java types that Jackson will use for simple data binding are:
     JSON Type       Java Type
     object          LinkedHashMap<String,Object>
     array           ArrayList<Object>
     string          String
     number(no fraction) Integer, Long or BigInteger (smallest applicable)
     number(fraction)    Double(configurable to use BigDecimal)
     true|false      Boolean
     null            null
     */
    @Test
    public void rawDataBinding() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        HashMap map = mapper.readValue(MODEL_BINDING,HashMap.class);//readValue到一个原始数据类型.
        System.out.println(map.get("name"));
        System.out.println(map.get("type"));
    }

    /**
     *  (3)generic Data Binding：

     * @throws Exception
     */
    @Test
    public void genericDataBinding() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String,Model> modelMap = mapper.readValue(GENERIC_BINDING,new TypeReference<HashMap<String,Model>>(){});//readValue到一个范型数据中.
        Model model = modelMap.get("key2");
        System.out.println(model.getName());
        System.out.println(model.getType());
    }

    @Test
    public void treeModelBinding() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(TREE_MODEL_BINDING);
        //path与get作用相同,但是当找不到该节点的时候,返回missing node而不是Null.
        String treekey2value = rootNode.path("treekey2").textValue();//
        System.out.println("treekey2value:" + treekey2value);
        JsonNode childrenNode = rootNode.path("children");
        String childkey1Value = childrenNode.get(0).path("childkey1").textValue();
        System.out.println("childkey1Value:"+childkey1Value);

        //创建根节点
        ObjectNode root = mapper.createObjectNode();
        //创建子节点1
        ObjectNode node1 = mapper.createObjectNode();
        node1.put("nodekey1",1);
        node1.put("nodekey2",2);
        //绑定子节点1
        root.put("child",node1);
        //数组节点
        ArrayNode arrayNode = mapper.createArrayNode();
        arrayNode.add(node1);
        arrayNode.add(1);
        //绑定数组节点
        root.put("arraynode", arrayNode);
        //JSON读到树节点
        JsonNode valueToTreeNode = mapper.valueToTree(TREE_MODEL_BINDING);
        //绑定JSON节点
        root.put("valuetotreenode",valueToTreeNode);
        //JSON绑定到JSON节点对象
        JsonNode bindJsonNode = mapper.readValue(GENERIC_BINDING, JsonNode.class);//绑定JSON到JSON节点对象.
        //绑定JSON节点
        root.put("bindJsonNode",bindJsonNode);
        System.out.println(mapper.writeValueAsString(root));
    }
}
