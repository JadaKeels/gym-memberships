package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Membership> memberships = new ArrayList<>();

        memberships.add(new BasicMembership(
                "Alice Johnson",
                6,
                new BigDecimal("30.00"),
                true));

        memberships.add(new BasicMembership(
                "Bob Smith",
                12,
                new BigDecimal("30.00"),
                false));

        memberships.add(new PremiumMembership(
                "Carol White",
                12,
                new BigDecimal("30.00"),
                3));

        memberships.add(new PremiumMembership(
                "Frank Miller",
                6,
                new BigDecimal("30.00"),
                1));

        memberships.add(new FamilyMembership(
                "Grace Lee",
                12,
                new BigDecimal("30.00"),
                3));

        memberships.add(new FamilyMembership(
                "Emma Wilson",
                6,
                new BigDecimal("30.00"),
                2));

// First loop
        for (Membership membership : memberships) {
            System.out.println(membership);
            printCosts(membership);
            System.out.println();
        }

// Second loop (Step 9)
        System.out.println("\n=== Front Desk Processing ===");

        for (Membership membership : memberships) {

            if (membership instanceof BasicMembership) {

                BasicMembership basic =
                        (BasicMembership) membership;

                if (basic.isOffPeakOnly()) {
                    System.out.println(
                            basic.getMemberName()
                                    + ": entry between 10:00 and 16:00 only");
                }

            } else if (membership instanceof PremiumMembership) {

                PremiumMembership premium =
                        (PremiumMembership) membership;

                premium.useGuestPass();

            } else if (membership instanceof FamilyMembership) {

                FamilyMembership family =
                        (FamilyMembership) membership;

                System.out.println(
                        family.getMemberName()
                                + ": print "
                                + (family.getExtraMembers() + 1)
                                + " key cards");
            }
        }
    }

    private static void printCosts(Membership membership) {

        System.out.println(
                "Monthly Fee: $"
                        + membership.calculateMonthlyFee());

        System.out.println(
                "Sign-Up Fee: $"
                        + membership.getSignUpFee());

        System.out.println(
                "Contract Total: $"
                        + membership.getContractTotal());
    }
}