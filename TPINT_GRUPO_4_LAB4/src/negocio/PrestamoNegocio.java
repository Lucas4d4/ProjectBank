package negocio;

import java.util.List;

import entidad.Prestamo;

public interface PrestamoNegocio {
	public List<Prestamo> ListarPrestamos();
	public List<Prestamo> ListarPedidosPrestamos();
	public int AgregarPrestamo(Prestamo prestamo);
	public int EliminarPedidoPrestamo(String NroPedido);
	public String traerNroCuentaPedido(String NroPedido);
	public float traerImporteSolicitado(String NroPedido);
	public int traerCantCuotasSolicitado(String NroPedido);
	public String verificarCampos(String Fecha, String Intereses, String Plazos, String MontoMes);
	public int insertPedidoPrestamo(Prestamo prestamo);
	
	public Prestamo buscarPrestamo(String dni);
}
