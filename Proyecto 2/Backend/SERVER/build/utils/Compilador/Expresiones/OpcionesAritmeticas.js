"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.getName = exports.get_simbolo = exports.OpcionesAritmeticas = void 0;
var OpcionesAritmeticas;
(function (OpcionesAritmeticas) {
    /*0*/ OpcionesAritmeticas[OpcionesAritmeticas["MAS"] = 0] = "MAS";
    /*1*/ OpcionesAritmeticas[OpcionesAritmeticas["MENOS"] = 1] = "MENOS";
    /*2*/ OpcionesAritmeticas[OpcionesAritmeticas["MULTIPLICACION"] = 2] = "MULTIPLICACION";
    /*3*/ OpcionesAritmeticas[OpcionesAritmeticas["DIV"] = 3] = "DIV";
    /*4*/ OpcionesAritmeticas[OpcionesAritmeticas["MODULO"] = 4] = "MODULO";
    /*5*/ OpcionesAritmeticas[OpcionesAritmeticas["POT"] = 5] = "POT";
    /*6*/ OpcionesAritmeticas[OpcionesAritmeticas["NEGACION"] = 6] = "NEGACION";
})(OpcionesAritmeticas = exports.OpcionesAritmeticas || (exports.OpcionesAritmeticas = {}));
/**
 *
 * @param objeto Enum ArithmeticOption
 * @return simbolo como string
 */
function get_simbolo(objeto) {
    switch (objeto) {
        case 0:
            return "+";
        case 1:
        case 6:
            return "-";
        case 2:
            return "*";
        case 3:
            return "/";
        case 4:
            return "%";
        case 5:
            return "**";
        default:
            return "";
    }
}
exports.get_simbolo = get_simbolo;
/**
 *
 * @param objeto Enum ArithmeticOption
 * @return nombre del simbolo en string
 */
function getName(objeto) {
    switch (objeto) {
        case 0:
            return "suma";
        case 1:
        case 6:
            return "resta";
        case 2:
            return "mutiplicacion";
        case 3:
            return "division";
        case 4:
            return "modulo";
        case 5:
            return "potencia";
        default:
            return "";
    }
}
exports.getName = getName;
