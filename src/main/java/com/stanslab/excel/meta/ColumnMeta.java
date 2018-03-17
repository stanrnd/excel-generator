package com.stanslab.excel.meta;

import com.stanslab.excel.pojo.parser.ValueParser;

/**
 * 
 * @author Stalin
 *
 */
public class ColumnMeta implements Comparable<ColumnMeta> {
	
	private String name;
	
	private int width;
	
	private int order;
	
	private ValueParser valueParser;
	
	public ColumnMeta() {
		
	}

	public ColumnMeta(String name) {
		this.name = name;
	}

	public Object getValue(Object row) {
		return valueParser.parse(row);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public ValueParser getValueParser() {
		return valueParser;
	}

	public void setValueParser(ValueParser valueParser) {
		this.valueParser = valueParser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.toUpperCase().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ColumnMeta other = (ColumnMeta) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equalsIgnoreCase(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(ColumnMeta o) {
		return this.order - o.order;
	}
	
}
