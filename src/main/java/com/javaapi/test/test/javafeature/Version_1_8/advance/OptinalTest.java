package com.javaapi.test.test.javafeature.Version_1_8.advance;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Optional;

/**
 * Created by user on 2019/4/5
 * refer
 * http://www.importnew.com/26066.html
 * https://www.baeldung.com/java-optional
 *
 *
 * 注意orElse  里如果配置的是方法,会被调用
 * 而 orElseGet则不会
 */
public class OptinalTest {

    /**
     * one call usage
     */
    @Test
    public void testGetNameOptional() {
        User u = null;
        String nameOptional = getNameOptional(u);
        System.out.println("nameOptional = " + nameOptional);
    }

    /**
     * chain call usage
     */
    @Test
    public void testGetChampionNameOptional() {
        Competition comp = new Competition();
        CompResult result = new CompResult();
        comp.setResult(result);
        System.out.println("result = " + result.getChampion());
        String championNameOptional = getChampionNameOptional(comp);
        System.out.println("championNameOptional = " + championNameOptional);
        User champion = new User();
        champion.setName("nihao");
        result.setChampion(champion);
        championNameOptional = getChampionNameOptional(comp);
        System.out.println("championNameOptional = " + championNameOptional);
    }

    @Test
    public void testOptionalFilter(){
        User user = new User();
        user.setName("nihao");
        System.out.println("user = " + user);
        user.setName("");
        System.out.println("user = " + user);
    }





    /**
     * this case is recommended
     *
     * @param u
     * @return
     */
    public static String getNameOptional(User u) {
        return Optional.ofNullable(u)
                       .map(user -> user.name)
                       .orElse("Unknown");
    }

    /**
     * You'd better do not use this in jdk 8
     *
     * @param u
     * @return
     */
    public static String getName(User u) {
        if (u == null) {
            return "Unknown";
        }
        return u.name;
    }

    public static String getChampionName(Competition comp) throws IllegalArgumentException {
        if (comp != null) {
            CompResult result = comp.getResult();
            if (result != null) {
                User champion = result.getChampion();
                if (champion != null) {
                    return champion.getName();
                }
            }
        }
        throw new IllegalArgumentException("The value of param comp isn't available.");
    }

    public static String getChampionNameOptional(Competition comp) throws IllegalArgumentException {
        return Optional.ofNullable(comp).map(competition -> competition.getResult())
                       .map(compResult -> compResult.getChampion())
                       .map(user -> user.getName())
                       .orElse("Unknown");
    }


    public static class User {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = Optional.ofNullable(name).filter(this::isNameValid)
                                .orElseThrow(()->new IllegalArgumentException("Invalid username."));
        }

        private boolean isNameValid(String s) {
            return StringUtils.isNotBlank(s);
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("User{");
            sb.append("name='").append(name).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    public static class Competition {
        private CompResult result;

        public CompResult getResult() {
            return result;
        }

        public void setResult(CompResult result) {
            this.result = result;
        }
    }

    public static class CompResult {
        private User champion;

        public User getChampion() {
            return champion;
        }

        public void setChampion(User champion) {
            this.champion = champion;
        }
    }

}
