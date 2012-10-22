package org.dsw.web.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the waterpoint_summary database table.
 * 
 */
@Entity
@Table(name="waterpoint_summary")
public class Waterpoint implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="waterpoint_id")
	private String id;


	@Column(name="_turbidity_wet_season")
	private String turbidityWetSeason;

	@Column(name="directions_from_nearest_market_center")
	private String directionsFromNearestMarketCenter;

	@Column(name="gps_coordinate_latitude")
	private String gpsCoordinateLatitude;

	@Column(name="gps_coordinate_longititude")
	private String gpsCoordinateLongititude;

	@Column(name="households_using_wpt_dry_season")
	private String householdsUsingWptDrySeason;

	@Column(name="households_using_wpt_wet_season")
	private String householdsUsingWptWetSeason;

	@Column(name="landowner_name")
	private String landownerName;

	@Column(name="landowner_personality")
	private String landownerPersonality;

	@Column(name="location_of_wpt")
	private String locationOfWpt;

	@Column(name="location_type")
	private String locationType;

	@Column(name="market_days_for_wpt")
	private String marketDaysForWpt;

	@Column(name="months_of_dry_season")
	private String monthsOfDrySeason;

	@Column(name="months_of_wet_season")
	private String monthsOfWetSeason;

	@Column(name="nearest_market_center")
	private String nearestMarketCenter;

	@Column(name="program_code")
	private String programCode;

	@Column(name="turbidity_dry_season")
	private String turbidityDrySeason;

	@Column(name="water_clear_or_turbid")
	private String waterClearOrTurbid;

	@Column(name="water_flow_rate")
	private String waterFlowRate;

	
	@Column(name="waterpoint_name")
	private String waterpointName;

	@Column(name="waterpoint_season")
	private String waterpointSeason;

	@Column(name="watersource_type")
	private String watersourceType;

    public Waterpoint() {
    }

	public String getTurbidityWetSeason() {
		return this.turbidityWetSeason;
	}

	public void setTurbidityWetSeason(String turbidityWetSeason) {
		this.turbidityWetSeason = turbidityWetSeason;
	}

	public String getDirectionsFromNearestMarketCenter() {
		return this.directionsFromNearestMarketCenter;
	}

	public void setDirectionsFromNearestMarketCenter(String directionsFromNearestMarketCenter) {
		this.directionsFromNearestMarketCenter = directionsFromNearestMarketCenter;
	}

	public String getGpsCoordinateLatitude() {
		return this.gpsCoordinateLatitude;
	}

	public void setGpsCoordinateLatitude(String gpsCoordinateLatitude) {
		this.gpsCoordinateLatitude = gpsCoordinateLatitude;
	}

	public String getGpsCoordinateLongititude() {
		return this.gpsCoordinateLongititude;
	}

	public void setGpsCoordinateLongititude(String gpsCoordinateLongititude) {
		this.gpsCoordinateLongititude = gpsCoordinateLongititude;
	}

	public String getHouseholdsUsingWptDrySeason() {
		return this.householdsUsingWptDrySeason;
	}

	public void setHouseholdsUsingWptDrySeason(String householdsUsingWptDrySeason) {
		this.householdsUsingWptDrySeason = householdsUsingWptDrySeason;
	}

	public String getHouseholdsUsingWptWetSeason() {
		return this.householdsUsingWptWetSeason;
	}

	public void setHouseholdsUsingWptWetSeason(String householdsUsingWptWetSeason) {
		this.householdsUsingWptWetSeason = householdsUsingWptWetSeason;
	}

	public String getLandownerName() {
		return this.landownerName;
	}

	public void setLandownerName(String landownerName) {
		this.landownerName = landownerName;
	}

	public String getLandownerPersonality() {
		return this.landownerPersonality;
	}

	public void setLandownerPersonality(String landownerPersonality) {
		this.landownerPersonality = landownerPersonality;
	}

	public String getLocationOfWpt() {
		return this.locationOfWpt;
	}

	public void setLocationOfWpt(String locationOfWpt) {
		this.locationOfWpt = locationOfWpt;
	}

	public String getLocationType() {
		return this.locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	public String getMarketDaysForWpt() {
		return this.marketDaysForWpt;
	}

	public void setMarketDaysForWpt(String marketDaysForWpt) {
		this.marketDaysForWpt = marketDaysForWpt;
	}

	public String getMonthsOfDrySeason() {
		return this.monthsOfDrySeason;
	}

	public void setMonthsOfDrySeason(String monthsOfDrySeason) {
		this.monthsOfDrySeason = monthsOfDrySeason;
	}

	public String getMonthsOfWetSeason() {
		return this.monthsOfWetSeason;
	}

	public void setMonthsOfWetSeason(String monthsOfWetSeason) {
		this.monthsOfWetSeason = monthsOfWetSeason;
	}

	public String getNearestMarketCenter() {
		return this.nearestMarketCenter;
	}

	public void setNearestMarketCenter(String nearestMarketCenter) {
		this.nearestMarketCenter = nearestMarketCenter;
	}

	public String getProgramCode() {
		return this.programCode;
	}

	public void setProgramCode(String programCode) {
		this.programCode = programCode;
	}

	public String getTurbidityDrySeason() {
		return this.turbidityDrySeason;
	}

	public void setTurbidityDrySeason(String turbidityDrySeason) {
		this.turbidityDrySeason = turbidityDrySeason;
	}

	public String getWaterClearOrTurbid() {
		return this.waterClearOrTurbid;
	}

	public void setWaterClearOrTurbid(String waterClearOrTurbid) {
		this.waterClearOrTurbid = waterClearOrTurbid;
	}

	public String getWaterFlowRate() {
		return this.waterFlowRate;
	}

	public void setWaterFlowRate(String waterFlowRate) {
		this.waterFlowRate = waterFlowRate;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWaterpointName() {
		return this.waterpointName;
	}

	public void setWaterpointName(String waterpointName) {
		this.waterpointName = waterpointName;
	}

	public String getWaterpointSeason() {
		return this.waterpointSeason;
	}

	public void setWaterpointSeason(String waterpointSeason) {
		this.waterpointSeason = waterpointSeason;
	}

	public String getWatersourceType() {
		return this.watersourceType;
	}

	public void setWatersourceType(String watersourceType) {
		this.watersourceType = watersourceType;
	}

}