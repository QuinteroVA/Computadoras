package com.computadoras.service.impl;
import com.computadoras.entity.Computadora;
import com.computadoras.repository.ComputadoraRepository;
import com.computadoras.service.ComputadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ComputadoraServiceImpl implements ComputadoraService {
  @Autowired
  private ComputadoraRepository computadoraRepository;
  @Override
  public List<Computadora> obtenerTodas() {
    return computadoraRepository.findAll();
  }
  @Override
  public Computadora obtenerPorId(Long id) {
    return computadoraRepository.findById(id).orElse(null);
  }
  @Override
  public Computadora crearComputadora(Computadora computadora) {
    return computadoraRepository.save(computadora);
  }
  @Override
  public Computadora actualizarComputadora(Long id, Computadora computadora) {
    Computadora computadoradb = computadoraRepository.findById(id).orElse(null);
    if (computadoradb != null) {
      computadoradb.setMarca(computadora.getMarca());
      computadoradb.setModelo(computadora.getModelo());
      computadoradb.setProcesador(computadora.getProcesador());
      computadoradb.setRam(computadora.getRam());
      computadoradb.setDisco(computadora.getDisco());
      computadoradb.setGrafica(computadora.getGrafica());
      return computadoraRepository.save(computadoradb);
    }
    return null;
  }
  @Override
  public void eliminarComputadora(Long id) {
    computadoraRepository.deleteById(id);
  }
  @Override
  public long contarComputadoras() {
    return computadoraRepository.count();
  }
}