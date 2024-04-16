package com.computadoras.service;
import com.computadoras.entity.Computadora;
import java.util.List;
public interface ComputadoraService {
  List<Computadora> obtenerTodas();
  Computadora obtenerPorId(Long id);
  Computadora crearComputadora(Computadora computadora);
  Computadora actualizarComputadora(Long id, Computadora computadora);
  void eliminarComputadora(Long id);
  long contarComputadoras();
}
