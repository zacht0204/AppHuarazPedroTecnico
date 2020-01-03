
package com.huaraz.luis.apphuarazTecnico.Servicio;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Peticion {

    @SerializedName("user")
    @Expose
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
