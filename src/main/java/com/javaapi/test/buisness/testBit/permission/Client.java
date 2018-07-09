package com.javaapi.test.buisness.testBit.permission;

import org.junit.Test;

/**
 * Created by user on 18/2/14.
 */
public class Client {
    @Test
    public void testSetPermission(){
        NewPermission newPermission = new NewPermission();
        newPermission.setPermission(NewPermission.ALLOW_INSERT);
        newPermission.setPermission(NewPermission.ALLOW_SELECT);
        System.out.println("newPermission = " + newPermission.isAllow(NewPermission.ALLOW_INSERT));
        System.out.println("newPermission = " + newPermission.isAllow(NewPermission.ALLOW_SELECT));
    }
    @Test
    public void testEnable(){
        NewPermission newPermission = new NewPermission();
        newPermission.enable(NewPermission.ALLOW_INSERT);
        System.out.println("newPermission = " + newPermission.isAllow(NewPermission.ALLOW_INSERT));
        System.out.println("newPermission = " + newPermission.isAllow(NewPermission.ALLOW_SELECT));
    }
    @Test
    public void testDisable(){
        NewPermission newPermission = new NewPermission();
        newPermission.enable(NewPermission.ALLOW_INSERT);
        newPermission.enable(NewPermission.ALLOW_SELECT);
        System.out.println("newPermission = " + newPermission.isAllow(NewPermission.ALLOW_INSERT));
        System.out.println("newPermission = " + newPermission.isAllow(NewPermission.ALLOW_SELECT));
        newPermission.disable(NewPermission.ALLOW_SELECT);
        System.out.println("newPermission = " + newPermission.isAllow(NewPermission.ALLOW_SELECT));
    }
    @Test
    public void testIsNotAllow(){
        NewPermission newPermission = new NewPermission();
        newPermission.enable(NewPermission.ALLOW_INSERT);
        newPermission.enable(NewPermission.ALLOW_SELECT);
        System.out.println("newPermission = " + newPermission.isAllow(NewPermission.ALLOW_INSERT));
        System.out.println("newPermission = " + newPermission.isAllow(NewPermission.ALLOW_SELECT));
        newPermission.disable(NewPermission.ALLOW_INSERT);
        newPermission.disable(NewPermission.ALLOW_SELECT);
        System.out.println("newPermission = " + newPermission.isNotAllow(NewPermission.ALLOW_INSERT | NewPermission.ALLOW_SELECT));
    }

    @Test
    public void testIsOnlyAllow(){
        NewPermission newPermission = new NewPermission();
        newPermission.enable(NewPermission.ALLOW_INSERT);
        newPermission.enable(NewPermission.ALLOW_SELECT);
        System.out.println("newPermission = " + newPermission.isOnlyAllow(NewPermission.ALLOW_SELECT));
    }

}
