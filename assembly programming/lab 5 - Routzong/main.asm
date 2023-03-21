; template to start a new project 
; 04/04/2021 Jacob Routzong
INCLUDE Irvine32.inc
.386
.model flat,stdcall
.stack 4096
ExitProcess proto,dwExitCode:dword

.data
	myString BYTE "h",0dh,0ah ;Add h and move to new line
	
.code

main proc

	;Exercise 6
     call ReadHexByte ;Reads value N from user
     call SumFirstN ;sum 1 + 2 + ... + N

     ;Print out sum
     mov CX, DX
     mov AL, CH ;move first two digits to al
     mov BL, 01h ;use this to tell writeHexByte to not put an h after first two digits
     call WriteHexByte ;print first two digits to console
     mov AL, CL ;move second to digits to al
     mov BL, 00h ;Use this to tell writeHexByte to put an h after first two digits
     call WriteHexByte ;print last two digits to console

	invoke ExitProcess,0
main endp

; Exercise 1
 
 DigitValue2ASCII proc
     mov DL, AL
     cmp DL, 09h
     jbe L1 ;jump if dl is 9 or less
     ja L2 ;jump if dl is A-F
L1:  
     add Dl, 30h ;ASCII of 0-9 is 30-39
     jmp L3 ;Jump to L3 so L2 doesn't execute
L2:
     sub Dl, 0Ah 
     add Dl, 41h ;ASCII of A-F is 41-46 
     
L3:
     ret ;Return to calling function

DigitValue2ASCII endp

; Exercise 2

WriteHexByte proc

	mov DH, AL ; stores al's original value
	and AL, 0F0h ; gets MSN
	shr AL, 4 ; makes MSN the LSN
	call DigitValue2ASCII ; stores dl in the ASCII of the MSN
	mov AL, DL ; moves the ASCII into al
	call WriteChar ; displays ASCII
	mov AL, DH ; moves original back to al
	and AL, 0Fh ; gets LSN
	call DigitValue2ASCII ; stores DL ASCII of LSN
	mov AL, DL 
	call WriteChar ; displays ASCII

	cmp BL, 01h
	JZ L2

L1: 
	mov AL, 68h ; ASCII for 'h'
	call WriteChar
	mov AL, 0Ah ; L/F
	call WriteChar
	mov AL, 0Dh ; C/R
	call WriteChar

L2:
	mov AL, DH ; return original value to al
	ret

WriteHexByte endp

; Exercise 3

ASCII2DigitValue proc
	mov DL, AL ;move ASCII to dl
	cmp DL, 39h
	jbe L1 ; jump if DL is 39h or less
	ja L2 ; jump if DL is more

L1: 
	sub DL, 30h ; ASCII of 0-9 is 30h-39h
	jmp L3 ; jump to L3 so L2 doesn't execute

L2: 
	sub DL, 41h ; ASCII of A-F is 41h-46h
	add DL, 0Ah

L3: 
	ret ; return to call
ASCII2DigitValue endp

; Exercise 4

ReadHexByte proc
	
	call ReadChar ; read 1st digit into al
	call ASCII2DigitValue ; change 1st digit from ASCII to digit
	call ReadChar ;read second digit into al 
    mov dh, dl ;temporarily put first digit into dh so it is not lost
    call ASCII2DigitValue ;change second digit from ASCII to value, store in DL
    mov al, dl ;move value of second digit to AL
    shl dh, 4 ;move dh 4 to make it most significant nibble
    add al, dh ;add AL and DH to create the actual value.
    ret ;return to calling function

ReadHexByte endp

; Exercise 5

SumFirstN proc
    
	mov ecx, 0h ;Set ecx to zero first
    mov cl, al ;move N into CL, determines the number of loops 
    mov dx, 0h ;start dx at 0
    mov bx, 1h ;number to add each loop, start at 1
Sum:
   
    add dx, bx
    add bx, 1h  ;increment bx so next add is one more
	loop sum ;Loops unti ECX = 0
    ret ;Return to calling function

SumFirstN endp

; Tests for all Exercises

test1 proc
    
	;Exercise 1 test values
     mov al, 05h 
     call DigitValue2ASCII ;DL should be 35h (53 dec)
     mov al, 0Ch
     call DigitValue2ASCII ;DL should be 43h (67 dec)

     ;Exercise 2 test values
     mov al, 15h
     call WriteHexByte ;Should print 15h
     mov al, 0E2h
     call WriteHexByte ;Should print E2h

     ;Exercise 3 Test values
     mov al, 33h
     call ASCII2DigitValue ; dl should contain 03h
     mov al, 45h
     call ASCII2Digitvalue ; dl should contain 0Eh

     ;Exercise 4 test
     call ReadHexByte
     call ReadHexbyte ;Call second time to allow another test of it

     ;Exercise 5 test
     mov al, 02h
     call SumFirstN ;DX should be 0003h
     mov al, 10h 
     call SumFirstN ;DX should be 136 (0088h)
     mov al, 0Fh
     call SumFirstN ;DX should be 120 (0078h) 

     ret 

test1 endp


end main