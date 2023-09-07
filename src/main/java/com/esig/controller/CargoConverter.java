package com.esig.controller;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.esig.model.Cargo;

@FacesConverter("cargoConverter")
public class CargoConverter implements Converter {

	private List<Cargo> listaCargos;
	
	
	
	public CargoConverter(List<Cargo> listaCargos) {
		this.listaCargos = listaCargos;
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null) return null;
		
		Integer id = Integer.valueOf(value);
		
		for(Cargo cargo : listaCargos) {
			if (id.equals(cargo.getId())) {
				return cargo;
			}
		}
		
		return null;
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) return null;
		
		Cargo cargo = (Cargo) value;
		
		return cargo.getId().toString();
		
	}

}
