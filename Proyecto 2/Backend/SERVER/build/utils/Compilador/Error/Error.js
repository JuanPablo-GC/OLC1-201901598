"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.error = void 0;
class error {
    constructor(tipo, descripcion, linea, columna) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.linea = linea;
        this.columna = columna;
    }
}
exports.error = error;
