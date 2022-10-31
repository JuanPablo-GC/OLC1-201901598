import { Instruccion } from "../Abstract/Instruccion";
import Arbol from '../Symbol/Three';
import tablaSimbolo from '../Symbol/SymbolTable';
import Tipo, {DataType} from '../Symbol/Type';




export default class Acceso extends Instruccion {
  id: String;

  constructor(id: String, fila: number, columna: number) {
    super(new Tipo(DataType.INDEFINIDO),fila, columna);
    this.id = id;
  }

  interpretar(arbol: Arbol, tabla: tablaSimbolo) {
    const value=tabla.getValor(this.id);

    
    //console.log("ESPACIOOOOOOOOOOO A VER EL VALOR DE LA VARIABLE")
    let tipoDato=value.tipo.getTipo();
    let a=value.getvalor();
    //console.log("VALOR DE LA VARIABLE: "+a);
    if(value && tipoDato==0){
        this.tipoDato.setTipo(DataType.ENTERO);
        return a;
    }
    if(value && tipoDato==1){
      this.tipoDato.setTipo(DataType.CADENA);
      return a;
    }
    if(value && tipoDato==2){
      this.tipoDato.setTipo(DataType.BOOLEAN);
      return a;
    }
    return null;
  
    
  }
 //para crear el arbol ast 
  public ast(arbol: Arbol) {
    const name_nodo = `node_${this.linea}_${this.columna}_`
    return `
    ${name_nodo};
    ${name_nodo}[label="${this.id}"];
    `
}
}