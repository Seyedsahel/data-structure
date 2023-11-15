def is_balanced(expression):
    stack = []
    opening_brackets = ['(', '[', '{']
    closing_brackets = [')', ']', '}']
    
    for char in expression:
        if char in opening_brackets:
            stack.append(char)
        elif char in closing_brackets:
            if not stack:
                return False
            top = stack.pop()
            if opening_brackets.index(top) != closing_brackets.index(char):
                return False
    
    return len(stack) == 0

# مثال‌هایی از استفاده از تابع
expressions = ["(2 + 3) * [5 - 4]",
               "{(4 * 5) + 2} - 1",
               "[(3 + 2) * 4",
               "({)}",
               "[(])"]

for expression in expressions:
    if is_balanced(expression):
        print(f"{expression} is balance")
    else:
        print(f"{expression} is not balance")