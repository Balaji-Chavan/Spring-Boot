package com.jpademo.stringsequence;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.SharedSessionContract;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.exception.spi.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;

import org.hibernate.service.ServiceRegistry;
import java.io.Serializable;
import java.util.Properties;
import org.hibernate.internal.util.config.ConfigurationHelper;
public class StringPrfixedSequenceIdGenerator extends SequenceStyleGenerator   {

    public static final String Value_Prefix_Parameter ="valuePrefix";
    public static  final String Value_Prefix_Default="";

    private String valuePrefix;

    public static final String Number_Format_Parameter ="number_Format";
    public static  final String Number_Format_default="%d";

    private String numberFormat;





    @Override
    public Serializable generate(SharedSessionContractImplementor session , Object object) throws HibernateException {
        return valuePrefix
                + String.format(numberFormat,super.generate(session,object));
    }

    @Override
    public  void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
  super.configure(LongType.INSTANCE,params,serviceRegistry);
  valuePrefix = ConfigurationHelper.getString(Value_Prefix_Parameter,params,Value_Prefix_Default);
  numberFormat = ConfigurationHelper.getString(Number_Format_Parameter,params,Number_Format_default);

    }
}
