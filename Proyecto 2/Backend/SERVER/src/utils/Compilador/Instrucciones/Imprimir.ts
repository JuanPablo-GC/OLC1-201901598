import { Instruccion } from "../Abstracto/Instruccion";
import { Expression } from "../Abstracto/Expresion";
import { Ambiente } from "../Simbolo/Ambiente";
import { Type } from "../Abstracto/Retorno";
import { Permanencia } from "../Permanencia/Permanencia";

export class Print extends Instruccion {

    constructor(
        public value: Expression,
        line: number,
        column: number
    ) {
        super(line, column);
    }

    public execute(Ambiente: Ambiente) {

        const s = Permanencia.getInstance()
        const expresion = this.value?.execute(Ambiente);
        if (expresion != null) {
            if (expresion.type != Type.error) s.add_consola(expresion.value)
        }
        s.add_consola("\n")
    }

    public ast() {
        const s = Permanencia.getInstance()
        const nombreNodo = `node_${this.line}_${this.column}_`
        s.add_ast(`
        ${nombreNodo}[label="\\<Instruccion\\>\\nconsole"];`)
        if (this.value!= null){s.add_ast(`${nombreNodo}->${this.value.ast()}`)}
    }
}