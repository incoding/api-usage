package com.javaapi.test.businessdesign.skill.bit.bit.bit2;

/**
 * http://blog.csdn.net/superbeck/article/details/5387476
 * 同时判断多个属性</br> 0x 表示16进制数字
 * 0x0001 是4个16机制位, 1个16机制位可以用4个二进制位标识,  所以4个16进制位相当于32个二进制位
 * @author wk
 */
public class ModifierBase {
    public static int PUBLIC = 0x0001;
    public static int PACKAGE = 0x0002;
    public static int PROTECTED = 0x0004;
    public static int PRIVATE = 0x0008;
    public static int STATIC = 0x0010;
    public static int ABSTRACT = 0x0020;
    public static int FINAL = 0x0040;

    private int modifier = 0;

    public ModifierBase(int modifier) {
        this.modifier = modifier;
    }

    public static void main(String[] args) {
        int modifiers1 = PUBLIC | PROTECTED;
        int modifiers2 = PUBLIC | PROTECTED | PRIVATE;
        ModifierBase base = new ModifierBase(modifiers2); // base is [PUBLIC |
        // PROTECTED |
        // PRIVATE]
        System.out.println(base.hasModifier(modifiers1)); // true because base
        // includes [PUBLIC
        // |
        // PROTECTED]
        ModifierBase base2 = new ModifierBase(modifiers1); // base is [PUBLIC |
        // PROTECTED]
        System.out.println(base2.hasModifier(modifiers2)); // fasle because
        // base2 donot
        // includes
        // [PRIVATE]
    }

    public boolean isPublic() {
        return (this.modifier & PUBLIC) != 0;
    }

    public boolean isPackage() {
        return (this.modifier & PACKAGE) != 0;
    }

    public boolean isProtected() {
        return (this.modifier & PROTECTED) != 0;
    }

    public boolean isPrivate() {
        return (this.modifier & PRIVATE) != 0;
    }

    public boolean hasModifier(int modifier) {
        return (this.modifier & modifier) == modifier;
    }

    public boolean hasnotModifier(int modifier) {
        return (this.modifier & modifier) == 0;
    }
}