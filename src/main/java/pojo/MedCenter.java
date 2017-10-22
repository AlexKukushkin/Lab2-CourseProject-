package pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class MedCenter implements Serializable{
    private int idMedCenter;
    private String centerName;
    private String regionName;
    private String locationName;

    public MedCenter() {
    }

    public MedCenter(int idMedCenter, String centerName, String regionName, String locationName) {
        this.idMedCenter = idMedCenter;
        this.centerName = centerName;
        this.regionName = regionName;
        this.locationName = locationName;
    }

//    public MedCenter(String centerName, String regionName, String locationName) {
//        this.idMedCenter = 0;
//        this.centerName = centerName;
//        this.regionName = regionName;
//        this.locationName = locationName;
//    }

    public int getIdMedCenter() {
        return idMedCenter;
    }

    @XmlElement
    public void setIdMedCenter(int idMedCenter) {
        this.idMedCenter = idMedCenter;
    }

    public String getCenterName() {
        return centerName;
    }

    @XmlElement
    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getRegionName() {
        return regionName;
    }

    @XmlElement
    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getLocationName() {
        return locationName;
    }

    @XmlElement
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
