package com.javaapi.test.test.javafeature.scope.model;

 class InnerEntity {
     private String id;
     private String name;



     public String getId() {
         return id;
     }

     public void setId(String id) {
         this.id = id;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     @Override
     public String toString() {
         final StringBuilder sb = new StringBuilder("Entity{");
         sb.append("id='").append(id).append('\'');
         sb.append(", name='").append(name).append('\'');
         sb.append('}');
         return sb.toString();
     }
 }
