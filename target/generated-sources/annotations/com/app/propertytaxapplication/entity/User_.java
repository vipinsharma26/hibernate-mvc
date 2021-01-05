package com.app.propertytaxapplication.entity;

import com.app.propertytaxapplication.utils.STATUS;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, Float> totalTax;
	public static volatile SingularAttribute<User, String> address;
	public static volatile SingularAttribute<User, Integer> constructedYear;
	public static volatile SingularAttribute<User, Zone> zone;
	public static volatile SingularAttribute<User, Property> property;
	public static volatile SingularAttribute<User, Integer> builtYear;
	public static volatile SingularAttribute<User, String> userName;
	public static volatile SingularAttribute<User, Integer> userId;
	public static volatile SingularAttribute<User, String> email;
	public static volatile SingularAttribute<User, Integer> assessmentYear;
	public static volatile SingularAttribute<User, STATUS> status;

	public static final String TOTAL_TAX = "totalTax";
	public static final String ADDRESS = "address";
	public static final String CONSTRUCTED_YEAR = "constructedYear";
	public static final String ZONE = "zone";
	public static final String PROPERTY = "property";
	public static final String BUILT_YEAR = "builtYear";
	public static final String USER_NAME = "userName";
	public static final String USER_ID = "userId";
	public static final String EMAIL = "email";
	public static final String ASSESSMENT_YEAR = "assessmentYear";
	public static final String STATUS = "status";

}

