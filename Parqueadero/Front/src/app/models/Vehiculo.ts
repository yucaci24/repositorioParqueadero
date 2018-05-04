export class Vehiculo {
    constructor(
    public placa: string,
    public tipo: number,
    public estado: boolean,
    public cilindraje: number,
    public fechaEntrada: Date,
    public cobro: number)
    {}
}