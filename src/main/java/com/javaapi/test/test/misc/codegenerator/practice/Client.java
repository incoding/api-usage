package com.javaapi.test.test.misc.codegenerator.practice;


import com.google.common.base.Splitter;
import com.javaapi.test.test.misc.codegenerator.practice.dataobject.OrderDO;
import com.javaapi.test.test.misc.codegenerator.practice.mapper.OrderDAO;
import com.javaapi.test.test.reflect.classScan.ClassUtil;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeSpec;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;
import org.junit.Test;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.testng.collections.Lists;

import javax.lang.model.element.Modifier;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by user on 2019/3/27
 */
public class Client {

    public static final String packageMapper = "com.javaapi.test.misc.codegenerator.practice.mapper";

    @Test
    public void test() {

        String packageName = "com.javaapi.test.misc.codegenerator.practice.mapper";
        List<Class<?>> classes = ClassUtil.getClasses(packageName);


        for (Class<?> aClass : classes) {
            TypeSpec.Builder helloWorld = TypeSpec.interfaceBuilder(aClass.getSimpleName()).addModifiers(Modifier.PUBLIC, Modifier.DEFAULT);

            Method[] declaredMethods = aClass.getDeclaredMethods();
            for (Method declaredMethod : declaredMethods) {
                int modifiers = declaredMethod.getModifiers();

                List<ParameterSpec> parameter = getParameter(declaredMethod);
                System.out.println(declaredMethod.getName());
                Modifier[] modifier = getModifiers(modifiers, modifier1 -> modifier1!=null);
                MethodSpec methodSpec = MethodSpec.methodBuilder(declaredMethod.getName())
                                             .returns(declaredMethod.getReturnType())
                                             .addModifiers(modifier).addParameters(parameter).build();

                helloWorld.addMethod(methodSpec);
            }
            TypeSpec build = helloWorld.build();
            JavaFile javaFile = JavaFile.builder("com.example.helloworld", build).build();
            try {
                javaFile.writeTo(System.out);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private List<ParameterSpec> getParameter(Method declaredMethod) {
        Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
        Parameter[] parameters = declaredMethod.getParameters();
        int length = parameters.length;
        List<ParameterSpec> objects = Lists.newArrayList();
        for (int i = 0; i < length; i++) {
            Parameter parameter = parameters[i];
            Modifier[] modifiers = getModifiers(parameter.getModifiers(), modifier -> modifier != null);
            Class<?> parameterType = parameterTypes[i];
            String paramterName = parameter.getName();
            ParameterSpec build = ParameterSpec.builder(parameterType, paramterName, modifiers).build();
            objects.add(build);
        }

        return objects;

    }


    private Modifier[] getModifiers(int modefiers, Predicate<Modifier> modifierPredicate){
        String modifier = java.lang.reflect.Modifier.toString(modefiers);
        Modifier[] modifiers = Splitter.on(" ").omitEmptyStrings().splitToList(modifier).stream().map(s -> Modifier.valueOf(s.toUpperCase())).filter(modifierPredicate).toArray(Modifier[]::new);
        return modifiers;
    }

    public static List<String> getParamterNames(Class clazz, String methodName){
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (methodName.equals(method.getName())) {
                String[] params = u.getParameterNames(method);
                return Arrays.asList(params);
            }
        }
        return null;
    }

    public static String[] getParamterNames(Method method){
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] params = u.getParameterNames(method);
        return params;
    }


    /**
     * 不能用
     * @throws NotFoundException
     */
    @Test
    public void test3() throws NotFoundException {
        try {
            //获取要操作的类对象
            ClassPool pool = ClassPool.getDefault();
            CtClass ctClass = pool.get("com.javaapi.test.misc.codegenerator.practice.mapper.OrderDAO");

            //获取要操作的方法参数类型数组，为获取该方法代表的CtMethod做准备
            Method method = OrderDAO.class.getMethod("insert", OrderDO.class);
            int count = method.getParameterCount();
            Class<?>[] paramTypes = method.getParameterTypes();
            CtClass[] ctParams = new CtClass[count];
            for (int i = 0; i < count; i++) {
                ctParams[i] = pool.getCtClass(paramTypes[i].getName());
            }

            CtMethod ctMethod = ctClass.getDeclaredMethod("insert", ctParams);
            //得到该方法信息类
            MethodInfo methodInfo = ctMethod.getMethodInfo();

            //获取属性变量相关
            CodeAttribute codeAttribute = methodInfo.getCodeAttribute();

            //获取方法本地变量信息，包括方法声明和方法体内的变量
            //需注意，若方法为非静态方法，则第一个变量名为this
            LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
            int pos = java.lang.reflect.Modifier.isStatic(method.getModifiers()) ? 0 : 1;

            for (int i = 0; i < count; i++) {
                System.out.println(attr.variableName(i + pos));

            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }

}
