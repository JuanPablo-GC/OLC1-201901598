export default class Type {
    private tipo: DataType;
  
    constructor(tipo: DataType) {
      this.tipo = tipo;
    }
    public getTipo(): DataType {
      return this.tipo;
    }
    public setTipo(tipo: DataType): void {
      this.tipo = tipo;
    }

    //para retornar el tipo en formato string
    public getTipo2(): string {
      let tipo="";
      switch ( this.tipo ) {
        case 0:
            // statement 1
            tipo="Int"
            return tipo;
        case 1:
            // statement 2
            tipo="String"
            return tipo;
            case 2:
              // statement 2
              tipo="Boleano"
              return tipo;
     }
      
     return tipo;
    }
}
  
export enum DataType {
    ENTERO,
    CADENA,
    BOOLEAN,
    //IDENTIFICADOR,
    INDEFINIDO
}