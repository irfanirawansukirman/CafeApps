package com.cafeapp.nizar.cafeapps;

import java.util.List;

/**
 * Created by irfan on 02/08/16.
 */
public class ModelCafe {
    public boolean STATUS;
    public int STATUS_CODE;
    public MESSAGE MESSAGE;

    public boolean isSTATUS() {
        return STATUS;
    }

    public void setSTATUS(boolean STATUS) {
        this.STATUS = STATUS;
    }

    public int getSTATUS_CODE() {
        return STATUS_CODE;
    }

    public void setSTATUS_CODE(int STATUS_CODE) {
        this.STATUS_CODE = STATUS_CODE;
    }

    public ModelCafe.MESSAGE getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(ModelCafe.MESSAGE MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public class MESSAGE {
        public String PROD;
        public String DEVEL;

        public String getPROD() {
            return PROD;
        }

        public void setPROD(String PROD) {
            this.PROD = PROD;
        }

        public String getDEVEL() {
            return DEVEL;
        }

        public void setDEVEL(String DEVEL) {
            this.DEVEL = DEVEL;
        }
    }

    public List<DATA> DATA;

    public List<ModelCafe.DATA> getDATA() {
        return DATA;
    }

    public void setDATA(List<ModelCafe.DATA> DATA) {
        this.DATA = DATA;
    }

    public class DATA {
        public String id;
        public String rating;
        public String nama;
        public String jenis;
        public String alamat;
        public String url_foto;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public String getJenis() {
            return jenis;
        }

        public void setJenis(String jenis) {
            this.jenis = jenis;
        }

        public String getAlamat() {
            return alamat;
        }

        public void setAlamat(String alamat) {
            this.alamat = alamat;
        }

        public String getUrl_foto() {
            return url_foto;
        }

        public void setUrl_foto(String url_foto) {
            this.url_foto = url_foto;
        }

    }
}
