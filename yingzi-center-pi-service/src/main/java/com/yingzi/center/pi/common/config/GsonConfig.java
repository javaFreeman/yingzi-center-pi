package com.yingzi.center.pi.common.config;

import com.google.gson.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class GsonConfig {
	@Bean
	public Gson gson() {
		return new GsonBuilder()
				.registerTypeAdapter(Timestamp.class, new TimestampTypeAdapter())
				.setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	}

	private class TimestampTypeAdapter implements JsonSerializer<Timestamp>, JsonDeserializer<Timestamp> {
		private final DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		@Override
		public Timestamp deserialize(JsonElement json, java.lang.reflect.Type typeOfT,
				JsonDeserializationContext context) throws JsonParseException {
			if (!(json instanceof JsonPrimitive)) {
				throw new JsonParseException("The date should be a string value");
			}
			try {
				Date date = format.parse(json.getAsString());
				return new Timestamp(date.getTime());
			} catch (ParseException e) {
				throw new JsonParseException(e);
			}
		}

		@Override
		public JsonElement serialize(Timestamp src, java.lang.reflect.Type typeOfSrc,
				JsonSerializationContext context) {
			String dateFormatAsString = format.format(new Date(src.getTime()));
			return new JsonPrimitive(dateFormatAsString);
		}
	}
}
