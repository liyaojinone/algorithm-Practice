package main

import (
	"errors"
	"fmt"
)

type stack struct {
	arr []int
	max int
	top int
}

func newStack(arr int) *stack {
	ints := make([]int, arr)
	return &stack{
		arr: ints,
		max: arr,
		top: -1,
	}
}
func main() {
	s2 := newStack(10)
	arr := []int{1, 3, 4, 6}
	err := s2.push(arr)
	if err != nil {
		println(err)
	}
	s2.show()

	s2.pop()
	s2.show()


}


func (s *stack) isFull() bool {
	return s.top == s.max-1
}
func (s *stack) isNull() bool {
	return s.top == -1
}
func (s *stack) push(n []int) error {
	if s.isFull() {
		println("栈满了")
		err := errors.New("栈满了")
		return err
	}
	for i := 0; i < len(n); i++ {
		s.top++
		s.arr[s.top] = n[i]
	}
	return nil
}
func (s *stack) pop() int {
	if s.isNull() {
		println("栈空了")
		return 0
	}
	value := s.arr[s.top]
	s.top--
	return value
}
func (s *stack)show()  {
	fmt.Println(s.arr)
	fmt.Printf("栈顶指针位%d，栈顶值为：%d\n",s.top,s.arr[s.top])
}
