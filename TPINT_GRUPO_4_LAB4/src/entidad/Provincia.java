package entidad;

public class Provincia {
	
	private int Id;
		private String Nombre;
			
		public Provincia() {}
		
		public Provincia(int id, String nombre) {
			super();
			Id = id;
			Nombre = nombre;
		}

		public int getId() {
			return Id;
		}

		public void setId(int id) {
			Id = id;
		}

		public String getNombre() {
			return Nombre;
		}

		public void setNombre(String nombre) {
			Nombre = nombre;
		}
}
