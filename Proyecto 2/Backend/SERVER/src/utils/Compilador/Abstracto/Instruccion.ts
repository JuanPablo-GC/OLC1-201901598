import { Ambiente } from "../Simbolo/Ambiente";

export abstract class Instruccion {

    constructor(public line: number, public column: number) {
        this.line = line
        this.column = column + 1
    }

    public abstract execute(Ambiente: Ambiente): any
    public abstract ast(): void

}