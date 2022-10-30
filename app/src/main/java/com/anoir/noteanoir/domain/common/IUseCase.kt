package com.anoir.noteanoir.domain.common


interface IUseCase {

    interface Input<in Input> {
        operator fun invoke(input: Input)
    }

    interface Output<out Output> {
        operator fun invoke(): Output
    }

    interface InputOutput<in Input, out Output> {
        operator fun invoke(input: Input): Output
    }

    interface Suspended {

        suspend operator fun invoke()

        interface Input<in Input> {
            suspend operator fun invoke(input: Input)
        }

        interface Output<out Output> {
            suspend operator fun invoke(): Output
        }

        interface InputOutput<in Input, out Output> {
            suspend operator fun invoke(input: Input): Output
        }
    }
}