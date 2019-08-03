package com.javaapi.test.test.misc.refactor.idearefactor;

/**
 * Created by user on 2018/10/27
 */
public class Worker {

    private final PersonImp1 personImp1 = new PersonImp1();

    public void test(){
        System.out.println("niaho");
        String nihao = "nihao";
        getPersonImp1().getValue().getPerson(nihao);
    }

    public MethodResp getPersonImp1() {
        return new MethodResp(personImp1);
    }

    public class MethodResp {
        private final PersonImp1 value;

        public MethodResp(PersonImp1 value) {
            this.value = value;
        }

        public PersonImp1 getValue() {
            return value;
        }
    }
}
