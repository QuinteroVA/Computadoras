package com.computadoras.controller;
import com.computadoras.entity.Computadora;
import com.computadoras.service.ComputadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Controller
@RequestMapping("/computadoras")
public class ComputadoraController {
  @Autowired
  private ComputadoraService computadoraService;
  @GetMapping
  public String listarComputadoras(Model model) {
    List<Computadora> computadoras = computadoraService.obtenerTodas();
    model.addAttribute("listaComputadoras", computadoras);
    return "computadoras";
  }
  @GetMapping("/nueva")
  public String mostrarFormularioDeNuevaComputadora(Model model) {
    model.addAttribute("computadora", new Computadora());
    model.addAttribute("accion", "/computadoras/nueva");
    return "computadora_form";
  }
  @PostMapping("/nueva")
  public String quardarNuevaComputadora(@ModelAttribute Computadora computadora) {
    computadoraService.crearComputadora(computadora);
    return "redirect:/computadoras";
  }
  @GetMapping("/editar/{id}")
  public String mostrarFormularioEditarComputadora(@PathVariable Long id, @ModelAttribute Computadora computadora, Model model) {

      model.addAttribute("computadoras", computadora);
      model.addAttribute("accion", "/computadoras/editar/"+id);
    return "computadora_form";
  }
  @PostMapping("editar/{id}")
  public String actualizarComputadora(@PathVariable Long id, @ModelAttribute Computadora computadora) {
    computadoraService.actualizarComputadora(id, computadora);
    return "redirect:/computadoras";
  }
  @GetMapping("/eliminar/{id}")
  public String eliminarComputadora(@PathVariable Long id) {
    computadoraService.eliminarComputadora(id);
    return "redirect:/computadoras";
  }
}
