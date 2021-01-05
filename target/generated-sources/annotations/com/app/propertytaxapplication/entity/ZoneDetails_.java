package com.app.propertytaxapplication.entity;

import com.app.propertytaxapplication.utils.STATUS;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ZoneDetails.class)
public abstract class ZoneDetails_ {

	public static volatile SingularAttribute<ZoneDetails, Float> rate;
	public static volatile SingularAttribute<ZoneDetails, Zone> zone;
	public static volatile SingularAttribute<ZoneDetails, Property> property;
	public static volatile SingularAttribute<ZoneDetails, Integer> id;
	public static volatile SingularAttribute<ZoneDetails, STATUS> status;

	public static final String RATE = "rate";
	public static final String ZONE = "zone";
	public static final String PROPERTY = "property";
	public static final String ID = "id";
	public static final String STATUS = "status";

}

