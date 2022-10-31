"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Literal = void 0;
const Expresion_1 = require("../Abstracto/Expresion");
const Retorno_1 = require("../Abstracto/Retorno");
class Literal extends Expresion_1.Expression {
    constructor(value, type, line, column) {
        super(line, column);
        this.value = value;
        this.type = type;
    }
    execute() {
        if (this.type == Retorno_1.Type.NUMBER)
            return { value: Number(this.value), type: Retorno_1.Type.NUMBER };
        else if (this.type == Retorno_1.Type.STRING)
            return { value: this.value, type: Retorno_1.Type.STRING };
        else if (this.type == Retorno_1.Type.BOOLEAN) {
            if (this.value == "true") {
                return { value: Boolean(true), type: Retorno_1.Type.BOOLEAN };
            }
            else {
                return { value: Boolean(false), type: Retorno_1.Type.BOOLEAN };
            }
        }
        else
            return { value: this.value, type: Retorno_1.Type.error };
    }
    ast() {
        const nombre = `node_${this.line}_${this.column}_`;
        if (this.type == Retorno_1.Type.STRING)
            return `
        ${nombre};
        ${nombre}[label="\\"${this.value.toString()}\\""];`;
        else
            return `
        ${nombre};
        ${nombre}[label="${this.value.toString()}"];`;
    }
}
exports.Literal = Literal;
