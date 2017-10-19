package com.briup.exam.common.util.jsonConfig;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

/**
 * 
 * 		   @author USER 
 * 		   JsonConfig jsonConfig = new JsonConfig();
 *         jsonConfig.registerJsonValueProcessor(java.util.Date.class, new
 *         DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss")); JSONObject jsonObj =
 *         JSONObject.fromObject(map, jsonConfig);
 *
 */

public class DateJsonValueProcessor implements JsonValueProcessor {

	public final String format = "yyyy-MM-dd";

	public Object processArrayValue(Object value, JsonConfig arg1) {
		String[] obj = {};
		if (value instanceof Date[]) {
			SimpleDateFormat sf = new SimpleDateFormat(format);
			Date[] dates = (Date[]) value;
			obj = new String[dates.length];
			for (int i = 0; i < dates.length; i++) {
				obj[i] = sf.format(dates[i]);
			}
		}
		return obj;

	}

	public Object processObjectValue(String arg0, Object obj, JsonConfig arg2) {
		if (obj instanceof Date && obj != null) {
			SimpleDateFormat dateFmt = new SimpleDateFormat(format);

			return dateFmt.format(obj);
		} else {
			return obj == null ? "" : obj.toString();
		}
	}

}
