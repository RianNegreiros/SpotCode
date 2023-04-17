import React from 'react'
import NavbarFooter from '../../components/common/navbar_footer'
import SectionWrapper from '../../components/common/section_wrapper'
import Discovery from '../../components/discovery'

export default function DiscoveryScreen() {
  return (
    <>
      <SectionWrapper>
        <Discovery />
      </SectionWrapper>
      <NavbarFooter />
    </>
  )
}