package db.entities;

import javax.persistence.*;

@Entity
@Table(name = "medcenter")
public class MedCenterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medcenter_id_seq_gen")
    @SequenceGenerator(allocationSize = 1, name = "medcenter_id_seq_gen", sequenceName = "public.\"medcenter_id_seq\"")
    private int idMedCenter;
    private String medcenterName;
    private String regionName;
    private String locationName;

    public MedCenterEntity(int idMedCenter, String medcenterName, String regionName, String locationName) {
        this.idMedCenter = idMedCenter;
        this.medcenterName = medcenterName;
        this.regionName = regionName;
        this.locationName = locationName;
    }

    @Id
    @Column(name = "id_medcenter")
    public int getIdMedCenter() {
        return idMedCenter;
    }

    @Column(name = "medcenter_name")
    public String getMedcenterName() {
        return medcenterName;
    }

    @Column(name = "region_name")
    public String getRegionName() {
        return regionName;
    }

    @Column(name = "location_name")
    public String getLocationName() {
        return locationName;
    }

    public void setIdMedCenter(int idMedCenter) {
        this.idMedCenter = idMedCenter;
    }

    public void setMedcenterName(String medcenterName) {
        this.medcenterName = medcenterName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
