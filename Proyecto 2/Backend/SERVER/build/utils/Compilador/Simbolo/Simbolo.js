"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Symbol = void 0;
class Symbol {
    /**
     * Clase que guarda toda la informacion importante de una variable y despues sera almacenada en la tabla de simbolos
     */
    constructor(value, id, type, edit) {
        this.value = value;
        this.id = id;
        this.type = type;
        this.edit = edit;
    }
}
exports.Symbol = Symbol;
