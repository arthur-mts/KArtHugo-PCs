package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import dao.PecaDAO;
import entities.Identificavel;

@FacesConverter(value = "ConversorPeca")
public class PecaConverter implements Converter {
	@Inject
	private PecaDAO dao;

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		return dao.getByID(Long.parseLong(value));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object object) {
		return ((Identificavel) object).getId().toString();
	}

}
