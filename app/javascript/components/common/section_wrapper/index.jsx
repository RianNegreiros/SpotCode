import React from 'react'
import { Container, Section } from 'react-bulma-components'

export function SectionWrapper(props) {
  return (
    <Section>
      <Container>
        {props.children}
      </Container>
    </Section>
  )
}