
package com.huaraz.luis.apphuarazTecnico.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

    public class Demo {

    @SerializedName("id_demo")
    @Expose
    private Integer id_demo;

        public String getId_foto1() {
            return id_foto1;
        }

        public void setId_foto1(String id_foto1) {
            this.id_foto1 = id_foto1;
        }

        @SerializedName("id_foto1")
    @Expose
    private String id_foto1;

    @SerializedName("id_foto2")
    @Expose
    private String id_foto2;

    @SerializedName("id_foto3")
    @Expose
    private String id_foto3;

    @SerializedName("id_distrito")
    @Expose
    private String id_distrito;

    @SerializedName("id_provincia")
    @Expose
    private String id_provincia;


    public Integer getId_demo() {
        return id_demo;
    }

    public void setId_demo(Integer id_demo) {
        this.id_demo = id_demo;
    }



    public String getId_foto2() {
        return id_foto2;
    }

    public void setId_foto2(String id_foto2) {
        this.id_foto2 = id_foto2;
    }

    public String getId_foto3() {
        return id_foto3;
    }

    public void setId_foto3(String id_foto3) {
        this.id_foto3 = id_foto3;
    }

    public String getId_distrito() {
        return id_distrito;
    }

    public void setId_distrito(String id_distrito) {
        this.id_distrito = id_distrito;
    }

    public String getId_provincia() {
        return id_provincia;
    }

    public void setId_provincia(String id_provincia) {
        this.id_provincia = id_provincia;
    }
}
