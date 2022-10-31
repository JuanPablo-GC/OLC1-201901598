import { Retorno } from "./Retorno"
import { Ambiente } from "../Simbolo/Ambiente"

export abstract class Expression {

    constructor(public line: number, public column: number) {
        this.line = line
        this.column = column + 1
    }

    public abstract execute(environment: Ambiente): Retorno
    public abstract ast(): string
}