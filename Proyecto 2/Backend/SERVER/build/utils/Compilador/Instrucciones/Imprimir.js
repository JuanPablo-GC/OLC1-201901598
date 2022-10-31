"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Print = void 0;
const Instruccion_1 = require("../Abstracto/Instruccion");
const Retorno_1 = require("../Abstracto/Retorno");
const Permanencia_1 = require("../Permanencia/Permanencia");
class Print extends Instruccion_1.Instruccion {
    constructor(value, line, column) {
        super(line, column);
        this.value = value;
    }
    execute(Ambiente) {
        var _a;
        const s = Permanencia_1.Permanencia.getInstance();
        const expresion = (_a = this.value) === null || _a === void 0 ? void 0 : _a.execute(Ambiente);
        if (expresion != null) {
            if (expresion.type != Retorno_1.Type.error)
                s.add_consola(expresion.value);
        }
        s.add_consola("\n");
    }
    ast() {
        const s = Permanencia_1.Permanencia.getInstance();
        const nombreNodo = `node_${this.line}_${this.column}_`;
        s.add_ast(`
        ${nombreNodo}[label="\\<Instruccion\\>\\nconsole"];`);
        if (this.value != null) {
            s.add_ast(`${nombreNodo}->${this.value.ast()}`);
        }
    }
}
exports.Print = Print;
