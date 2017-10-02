package classes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class MedCenter implements Serializable{
    private int idMedCenter;
    private String centerName;
    private int idRegion;
    private String regionName;
    private int idLocation;
    private String locationName;

    public MedCenter() {
    }

    public MedCenter(int idMedCenter, String centerName, int idRegion, String regionName, int idLocation, String locationName) {
        this.idMedCenter = idMedCenter;
        this.centerName = centerName;
        this.idRegion = idRegion;
        this.regionName = regionName;
        this.idLocation = idLocation;
        this.locationName = locationName;
    }

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

    public int getIdRegion() {
        return idRegion;
    }

    @XmlElement
    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    public String getRegionName() {
        return regionName;
    }

    @XmlElement
    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public int getIdLocation() {
        return idLocation;
    }

    @XmlElement
    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public String getLocationName() {
        return locationName;
    }

    @XmlElement
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
