Package main 
import( 
"math" 
"fmt" 
)
var _variable1_ int =5
 var _curso1_ int ="olc"
var _curso2_ int ="olc"
var _curso3_ int ="olc"
var _pi1_ int =3
var _pi2_ int =3.1
var _pi3_ int =3.14
var _pi4_ int =3.141
var _anio1_ int =1
var _anio2_ int =9
var _anio3_ int =4
var _anio4_ int =5
 var _encabezado1_ int ="universidad san carlos de guatemala...;"
var _encabezado2_ int ="escuela de ciencias y sistemas
segundo semestre
"
var _flag1_ int =null
var _flag2_ int =null
var _name1_ int ='f'
var _name2_ int ='e'
var _name3_ int ='r'
var _name4_,_name6_ int ='n'
var _name5_ int ='a'
var _name7_ int ='${100}'
var _name8_ int ='${111}'
var _operaciones1basica_ int =1+(1)
var _operaciones1basica2_ int =_operaciones1basica_+_operaciones1basica_
var _operaciones1intermedia_ int =15+(9*8)+200/8*3+9
var _operaciones1avanzadas1_ int =((15+9)*8+200/8*3+9)
var _operaciones1avanzadas2_ int =math.Pow(float64(30),float64(22.2-2.2)) +(2)
var _operaciones1avanzadas3_ int =(math.Pow(float64(30),float64(2)) )+(2)
var _operaciones1avanzadas4_ int =(math.Pow(float64(30),float64(10-8+9-4*2-1)) )+(2)
 var _operaciones1avanzadas6_ int =(5*8)%(1+5+6)
 var _operacionrela3_ int =_operaciones1basica_ > 8
var _operacionrela3_ int =(_operaciones1basica_+6) >= 8
var _operacionrela3_ int =(_operaciones1basica_+6) <= 8
var _operacionrela4_ int =_operaciones1basica_ == 8
var _operacionrela5_ int =_operaciones1basica_ == _operaciones1basica_
var _operacionrela6_ int =_operaciones1basica_ == _operaciones1basica_+1
var _operacionrela7_ int =_operaciones1basica_ == (_operaciones1basica_)*(8+5)
  _v2_,_v3_="estas cadenas deben ser diferentes"
_curso1_,_curso2_,_curso3_="organizacion de lenguajes y compiladores 1"
_curso1_,_curso2_,_curso3_ fmt.Printf(_encabezado1_) 
fmt.Printf(_encabezado2_) 
fmt.Printf("...") 
fmt.Printf(_anio1_) 
fmt.Printf(_anio2_) 
fmt.Printf(_anio3_) 
fmt.Printf(_anio4_) 
fmt.Printf(".") 
fmt.Printf((_v3_)) 
if (_v1_ == _v2_){
fmt.Printf("al parecer no funciona la asignacion") 
for true{ 
if(null){ 
break }
fmt.Printf(_variable1_) 
_variable1_=_variable1_+1
}
}

nullif (_v1_ == _v2_){
fmt.Printf("no tiene que imprimir este mensaje") 
}
else if(_v1_ == 13){ 
fmt.Printf("mensaje de prueba") 
}else if(_v1_ == 14){ 
fmt.Printf("mensaje de prueba") 
}else{ 
fmt.Printf("este print es un ejemplo") 
}\nvar _varb_ int =null
  func _potenciamanual_( _base_ int, _exponenete_ int){
var _i_ int =0
var _acumulado_ int =0
for _i_:=0;_i_<_exponente_-1{
_acumulado_=_acumulado_+_acumulado_
}

fmt.Printf(_acumulado_) 
fmt.Printf(" esta es la potencia manual") 

}
func _potenciafuncion_( _base_ int, _exponente_ int) numero {
var _potencia_ int =math.Pow(float64(_base_),float64(_exponente_)) 
return _potencia_

}
func _metodo_1_(){ 
fmt.Printf("estamos entrando al metodo 1") 
_potenciamanual_(3*1+4/2,3+2) 
fmt.Printf(_potenciafuncion_(3*1+4/2,3+2) 
) 
  }

_metodo_1_() 
