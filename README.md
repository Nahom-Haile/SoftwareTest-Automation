# SoftwareTest-Automation

Nahom Haile
06.28.2026
Reflection

How can I ensure that my code, program, or software is functional and secure?

I ensured functionality primarily through requirements-driven unit
testing rather than manual checking. For every field or method, I would
write a positive test confirming valid input is accepted and one or more
negative tests confirming invalid input is rejected with a specific
exception. I pay particular attention to boundary values, testing inputs
exactly at a length or date limit, not just comfortably within or outside of
it, because defects tend to cluster at the edge cases. Security and robustness
follow from the same discipline of validating every input at the point it
enters the system to prevent bad data from propagating deeper into the
application, where it would be harder to trace and more costly to fix. I also
try to think defensively about mutable state. for example, when working with
java.util.Date, I store and return defensive copies rather than direct
references, so that external code cannot silently corrupt an object's
internal state after it has already been validated.

How do I interpret user needs and incorporate them into a program?

I would treat the customer's written requirements as the source of solutions
and work to translate every individual sentence into a corresponding piece of
validation logic or test case, rather than relying on my own assumptions
about what the user might have meant. When a requirement is ambiguous or
technically specific, such as the instruction to use before(new Date()) to
determine whether an appointment date has already passed, I implement it
exactly as specified rather than substituting a method I find more familiar.
This traceability matters because it gives the customer confidence that the code does what was actually asked for, and it
makes it possible to point to a specific test as evidence that a specific
requirement has been met.

How do I approach designing software?

To approach designing software, I would start by separating concerns clearly: a model class is responsible only for
representing a single object and enforcing its own validation rules, while a
service class is responsible only for managing a collection of those objects
and the operations performed on them. This separation keeps each class small,
focused, and easier to test in isolation. I favor immutability wherever the
requirements allow it, such as marking a unique ID field final with no
corresponding setter, because immutable fields eliminate an entire category of
bugs related to unexpected state changes. I also try to centralize validation
logic in one place, typically the model class's constructor and setters, so
that a business rule only needs to be implemented and tested once rather than
duplicated across multiple call sites. Finally, I design with testability in
mind from the start, since code that is easy to construct, isolate, and
inspect in a unit test is very often the same code that is well-structured
and maintainable in production.
