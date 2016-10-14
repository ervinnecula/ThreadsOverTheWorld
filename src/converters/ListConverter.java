package converters;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.google.common.base.Joiner;

@Converter
public class ListConverter implements AttributeConverter<List<String>, String>, Serializable {

	private static final long serialVersionUID = -7556458217517192431L;

	@Override
	public String convertToDatabaseColumn(List<String> tags) {
		return Joiner.on(",").join(tags);
	}

	@Override
	public List<String> convertToEntityAttribute(String tagsColumn) {
		return Arrays.asList(tagsColumn.split(","));
	}
}
