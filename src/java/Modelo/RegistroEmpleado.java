/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.ControlRegistroEmpleado;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author Luis
 */
public class RegistroEmpleado {

    private Document document;
    private Element root;
    private String path;

    private RegistroEmpleado(String path) {
        try {
            SAXBuilder saxb = new SAXBuilder();
            saxb.setIgnoringElementContentWhitespace(true);
            this.document = saxb.build(path);
            this.path = path;
            this.root = document.getRootElement();
        } catch (JDOMException ex) {
            Logger.getLogger(RegistroEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RegistroEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private RegistroEmpleado(String path, String rootName) {
        this.path = path;
        this.root = new Element(rootName);
        this.document = new Document(root);
        guardar();
    }

    private void guardar() {
        try {
            XMLOutputter xmlo = new XMLOutputter();
            xmlo.output(document, new PrintWriter(this.path));
            xmlo.output(document, System.out);
        } catch (IOException ex) {
            Logger.getLogger(RegistroEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static RegistroEmpleado crearDocumento(String path) {
        return new RegistroEmpleado(path, "empleados");
    }

    public static RegistroEmpleado abrirDocumento(String path) {
        return new RegistroEmpleado(path);
    }

    public void agregarEmpleado(Empleado empleado) {
        Element eEmpleado = new Element("empleado");

        Element eNomnre = new Element("nombre");
        Attribute aCedula = new Attribute("cedula", empleado.getCedula());
        Element eTelefono = new Element("telefono");
        Element ePuesto = new Element("puesto");
        Element eTipoTrabajo = new Element("tipoTrabajo");
        Element eCantidadHoras = new Element("cantidadHoras");
        Element eCantidadHorasExtra = new Element("cantidadHorasExtra");
        Element eAsignacionFamiliar = new Element("asignacionFamiliar");
        Element eMontoAsignacion = new Element("montoAsignacion");
        Element eDuracionServicio = new Element("duracionServicio");
        Element eSalarioBase = new Element("salarioBase");

        eNomnre.addContent(empleado.getNombre());
        eTelefono.addContent(empleado.getTelefono());
        ePuesto.addContent(empleado.getPuesto());
        eTipoTrabajo.addContent(empleado.getTipoTrabajo());
        eCantidadHoras.addContent(Integer.toString(empleado.getCantidadHoras()));
        eCantidadHorasExtra.addContent(Integer.toString(empleado.getCantidadHorasExtras()));
        eAsignacionFamiliar.addContent(empleado.getAsignacion());
        eMontoAsignacion.addContent(Integer.toString(empleado.getMontoAsignacion()));
        eDuracionServicio.addContent(empleado.getDuracion());
        eSalarioBase.addContent(Double.toString(empleado.getSalarioBase()));

        eEmpleado.addContent(eNomnre);
        eEmpleado.setAttribute(aCedula);
        eEmpleado.addContent(eTelefono);
        eEmpleado.addContent(ePuesto);
        eEmpleado.addContent(eTipoTrabajo);
        eEmpleado.addContent(eCantidadHoras);
        eEmpleado.addContent(eCantidadHorasExtra);
        eEmpleado.addContent(eAsignacionFamiliar);
        eEmpleado.addContent(eMontoAsignacion);
        eEmpleado.addContent(eDuracionServicio);
        eEmpleado.addContent(eSalarioBase);
        root.addContent(eEmpleado);
        guardar();
    }

    public Element buscarEmpleado(String cedula, Empleado empleado) {
        List<Element> elementos = (List<Element>) root.getChildren();
        boolean encontro = false;

        for (Element elemento : elementos) {
            if (elemento.getAttributeValue("cedula").equals(cedula)) {                  
                
                empleado.setNombre(elemento.getChildText("nombre"));
                empleado.setTelefono(elemento.getChildText("telefono"));
                empleado.setPuesto(elemento.getChildText("puesto"));
                empleado.setCantidadHoras(Integer.parseInt(elemento.getChildText("cantidadHoras")));
                empleado.setCantidadHorasExtras(Integer.parseInt(elemento.getChildText("cantidadHorasExtra")));
                empleado.setMontoAsignacion(Integer.parseInt(elemento.getChildText("montoAsignacion")));
                empleado.setDuracion(elemento.getChildText("duracionServicio"));
                empleado.setSalarioBase(Double.parseDouble(elemento.getChildText("salarioBase")));
                empleado.setTipoTrabajo(elemento.getChildText("tipoTrabajo"));
                empleado.setAsignacion(elemento.getChildText("asignacionFamiliar"));
                encontro = true;
                return elemento;

            }
            

        }
        if(encontro!=true){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "El empleado no se encontró", "Empleado no encontrado"));
        }
        return null;
    }

    

    public Element buscarEmpleado2(String cedula) {
        List<Element> elementos = (List<Element>) root.getChildren();

        for (Element elemento : elementos) {
            if (elemento.getAttributeValue("cedula").equals(cedula)) {

                return elemento;

            }
        }
        return null;

    }
    

    public String modificarEmpleado(Empleado empleado, String cedula) {
        Element empleadoEncontrado = this.buscarEmpleado2(cedula);
        if (empleadoEncontrado != null) {
            empleadoEncontrado.getChild("nombre").setText(empleado.getNombre());
            empleadoEncontrado.getChild("telefono").setText(empleado.getTelefono());
            empleadoEncontrado.getChild("puesto").setText(empleado.getPuesto());
            empleadoEncontrado.getChild("cantidadHoras").setText(Integer.toString(empleado.getCantidadHoras()));
            empleadoEncontrado.getChild("cantidadHorasExtra").setText(Integer.toString(empleado.getCantidadHorasExtras()));
            empleadoEncontrado.getChild("montoAsignacion").setText(Integer.toString(empleado.getMontoAsignacion()));
            empleadoEncontrado.getChild("duracionServicio").setText(empleado.getDuracion());
            empleadoEncontrado.getChild("salarioBase").setText(Double.toString(empleado.getSalarioBase()));
            empleadoEncontrado.getChild("tipoTrabajo").setText(empleado.getTipoTrabajo());
            empleadoEncontrado.getChild("asignacionFamiliar").setText(empleado.getAsignacion());
            guardar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Empleado modificado", "Empleado Modificado"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "El empleado no se encontró", "Empleado no encontrado"));
        }
        return "sesionAdministrador";
    }

    public void eliminar(Element empleado,Empleado empleado1, ControlRegistroEmpleado controlRegistroEmpleado) {   
                empleado1.setNombre("");
                empleado1.setTelefono("");
                empleado1.setPuesto("");
                empleado1.setCantidadHoras(0);
                empleado1.setCantidadHorasExtras(0);
                empleado1.setMontoAsignacion(0);
                empleado1.setDuracion("");
                empleado1.setSalarioBase(0);
                empleado1.setTipoTrabajo("");
                empleado1.setAsignacion("");
                controlRegistroEmpleado.setCedula("");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Empleado eliminado", "Empleado Modificado"));
        root.removeContent(empleado);
        guardar();
    }
}

