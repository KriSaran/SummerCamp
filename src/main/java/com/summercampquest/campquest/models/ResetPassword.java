package com.summercampquest.campquest.models;

import java.io.Serializable;

public class ResetPassword implements Serializable {

   private String password;
   private String retypePassword;
   private String token;

   public String getToken() {
      return token;
   }

   public String getRetypePassword() {
      return retypePassword;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }
}
