package com.recetario.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.recetario.model.Dificultad;
import com.recetario.model.Racion;
import com.recetario.model.Receta;
import com.recetario.model.Tipo;
import com.recetario.repository.DificultadRepository;
import com.recetario.repository.RacionRepository;
import com.recetario.repository.RecetaRepository;
import com.recetario.repository.TipoRepository;

@Controller
public class MenuController {
	@Autowired
	private RecetaRepository recetaRepo;
	
	@Autowired
	private DificultadRepository dificultadRepo;
	
	@Autowired
	private TipoRepository tipoRepo;
	
	@Autowired
	private RacionRepository racionRepo;
	
	
	@RequestMapping("/menu_recetas")
	public String menu_recetas(Model model,
	                           @RequestParam(value = "dificultad", required = false) Integer dificultadId,
	                           @RequestParam(value = "tipo", required = false) Integer tipoId,
	                           @RequestParam(value = "ingrediente", required = false) String ingrediente) {
	    List<Receta> listaRecetas;
	    
	    if (ingrediente != null && !ingrediente.isEmpty()) {
	        if (dificultadId != null && tipoId != null) {
	            listaRecetas = recetaRepo.findByIngredientesContainingIgnoreCaseAndDificultadIdAndTipoId(ingrediente, dificultadId, tipoId);
	        } else if (dificultadId != null) {
	            listaRecetas = recetaRepo.findByIngredientesContainingIgnoreCaseAndDificultadId(ingrediente, dificultadId);
	        } else if (tipoId != null) {
	            listaRecetas = recetaRepo.findByIngredientesContainingIgnoreCaseAndTipoId(ingrediente, tipoId);
	        } else {
	            listaRecetas = recetaRepo.findByIngredientesContainingIgnoreCase(ingrediente);
	        }
	    } else {
	        if (dificultadId != null && tipoId != null) {
	            listaRecetas = recetaRepo.findByDificultadIdAndTipoId(dificultadId, tipoId);
	        } else if (dificultadId != null) {
	            listaRecetas = recetaRepo.findByDificultadId(dificultadId);
	        } else if (tipoId != null) {
	            listaRecetas = recetaRepo.findByTipoId(tipoId);
	        } else {
	            listaRecetas = recetaRepo.obtenerTodasRecetas();
	        }
	    }
	    
	    model.addAttribute("atr_lista_recetas", listaRecetas);
	    
	    List<Dificultad> listaDificultades = dificultadRepo.findAll();
	    model.addAttribute("atr_lista_dificultades", listaDificultades);
	    
	    List<Tipo> listaTipos = tipoRepo.findAll();
	    model.addAttribute("atr_lista_tipos", listaTipos);
	    
	    return "recetas";
	}


	
	
    @GetMapping("/recetas/{id}")
    public String verDetalleReceta(@PathVariable("id") long id, Model model) {
        Optional<Receta> optionalReceta = recetaRepo.findById(id);
        if (optionalReceta.isPresent()) {
            Receta receta = optionalReceta.get();
            model.addAttribute("receta", receta);
            return "detalle_receta";
        } else {
            model.addAttribute("errorMensaje", "Receta no encontrada");
            return "error"; 
        }
    }
	
	
    @GetMapping("/recetas/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Receta receta = recetaRepo.findById(id)
          .orElseThrow(() -> new IllegalArgumentException("ID de receta no encontrado:" + id));
        
        model.addAttribute("receta", receta);
        model.addAttribute("dificultades", dificultadRepo.findAll());
        model.addAttribute("tipos", tipoRepo.findAll());
        model.addAttribute("raciones", racionRepo.findAll());
        return "actualizar_receta";
    }

    @PostMapping("/recetas/update/{id}")
    public String updateReceta(@PathVariable("id") long id, @ModelAttribute Receta receta, BindingResult result, Model model) {
        if (result.hasErrors()) {
            receta.setId(0);
            return "actualizar_receta";
        }

        recetaRepo.save(receta);
        return "redirect:/menu_recetas";
    }

    @GetMapping("/recetas/delete/{id}")
    public String deleteReceta(@PathVariable("id") long id, Model model) {
        Receta receta = recetaRepo.findById(id)
          .orElseThrow(() -> new IllegalArgumentException("ID de receta no encontrado:" + id));
        recetaRepo.delete(receta);
        return "redirect:/menu_recetas";
    }
    
    
    
    
	
	
	@RequestMapping("/menu_nueva_receta")
	public String menu_nueva_receta(Model model) {
		
		List<Receta> listaRecetas= recetaRepo.findAll();
		List<Dificultad> listaDificultades=dificultadRepo.findAll();
		List<Tipo> listaTipos=tipoRepo.findAll();
		List<Racion> listaRaciones=racionRepo.findAll();
		
		model.addAttribute("atr_lista_recetas", listaRecetas);
		model.addAttribute("atr_lista_dificultades", listaDificultades);
		model.addAttribute("atr_lista_tipos", listaTipos);
		model.addAttribute("atr_lista_raciones", listaRaciones);
		
		model.addAttribute("objeto_entidad", new Receta());
		
		return "nueva_receta";
	}
	
	@RequestMapping("/guardar_receta")
	public String guardarReceta(@ModelAttribute Receta objeto_entidad) {
		
		//guardamos el nuevo objeto 
		recetaRepo.save(objeto_entidad);
		
		return "redirect:/";
	}
	
	
	@RequestMapping("menu_ruleta")
	public String menu_ruleta() {
		return "ruleta";
	}
	
	
	@GetMapping("/receta_aleatoria")
	@ResponseBody
	public String obtenerRecetaAleatoria() {
	    Receta recetaAleatoria = recetaRepo.obtenerRecetaAleatoria();
	    return "<div class='card'>"
	        + "<a href='/recetas/" + recetaAleatoria.getId() + "' class='card-link'>" // pag. detalles
	        + "<img src='" + recetaAleatoria.getImagenUrl() + "' alt='Imagen de la Receta'/>"
	        + "<div class='contenido-receta'>"
	        + "<h3>" + recetaAleatoria.getNombreReceta() + "</h3>"
	        + "<p><span>🥕 Ingredientes:</span> " + recetaAleatoria.getIngredientes() + "</p>"
	        + "<p><span>🕔 Duración:</span> " + recetaAleatoria.getDuracion() + "</p>"
	        + "<p><span>⭐ Dificultad:</span> " + recetaAleatoria.getDificultad().getDificultad() + "</p>"
	        + "</div>"
	        + "</a>"
	        + "</div>";
	}


	
}
