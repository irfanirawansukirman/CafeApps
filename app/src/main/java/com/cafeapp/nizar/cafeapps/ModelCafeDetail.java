package com.cafeapp.nizar.cafeapps;

import java.io.Serializable;
import java.util.List;

/**
 * Created by irfan on 03/08/16.
 */
public class ModelCafeDetail implements Serializable {
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

    public ModelCafeDetail.MESSAGE getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(ModelCafeDetail.MESSAGE MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public class MESSAGE implements Serializable {
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

    public DATA DATA;

    public DATA getDATA() {
        return DATA;
    }

    public void setDATA(DATA DATA) {
        this.DATA = DATA;
    }

    public class DATA {
        public String nama;
        public LOCATION location;
        public String alamat;
        public String deskripsi;
        public List<FASILITAS> fasilitas;

        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public LOCATION getLocation() {
            return location;
        }

        public void setLocation(LOCATION location) {
            this.location = location;
        }

        public String getAlamat() {
            return alamat;
        }

        public void setAlamat(String alamat) {
            this.alamat = alamat;
        }

        public String getDeskripsi() {
            return deskripsi;
        }

        public void setDeskripsi(String deskripsi) {
            this.deskripsi = deskripsi;
        }

        public List<FASILITAS> getFasilitas() {
            return fasilitas;
        }

        public void setFasilitas(List<FASILITAS> fasilitas) {
            this.fasilitas = fasilitas;
        }
    }

    public class LOCATION {
        public List<String> latitude;
        public List<String> longitude;

        public List<String> getLatitude() {
            return latitude;
        }

        public void setLatitude(List<String> latitude) {
            this.latitude = latitude;
        }

        public List<String> getLongitude() {
            return longitude;
        }

        public void setLongitude(List<String> longitude) {
            this.longitude = longitude;
        }
    }

    public class FASILITAS {
        public String nama;

        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }
    }
}
