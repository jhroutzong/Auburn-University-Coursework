; template to start a new project 
; 12/29/2017 Saad Biaz
INCLUDE Irvine32.inc
.386
.model flat,stdcall
.stack 4096
ExitProcess proto,dwExitCode:dword
	
.data
	
	
.code
main proc
	MOV EAX, 0FFFDh
	inc EAX
	inc EAX
	inc EAX
	MOV EAX, 0FFFDh
	inc AL
	inc AL
	inc AL
	

	invoke ExitProcess,0
main endp
end main